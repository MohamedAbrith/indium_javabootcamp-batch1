package com.indium.capstone.Service;

import com.indium.capstone.Dao.AssociatesDao;
import com.indium.capstone.Dao.AssociatesDaoJdbc;
import com.indium.capstone.Model.Associates;
import com.indium.capstone.Model.Skill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AssociateSkillTrack implements AssociateSkills{
    private List<Associates> associates = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    AssociatesDao associatesDao;
    public AssociateSkillTrack(){
        associatesDao=new AssociatesDaoJdbc();
    }
    public void addAssociate(Associates associate) {
        associatesDao.create(associate);
    }
    public void listAssociates() {
        associates = associatesDao.getall();
        for (Associates associate : associates) {
            associate.viewDetails();
            System.out.println();
        }
    }
   public void editAssociate(int associateID, Associates updatedAssociate) {
       boolean editAssociate= associatesDao.update(updatedAssociate);
   }

    public void deleteAssociate(int associateId) {
        boolean delete = associatesDao.delete(associateId);
    }

    public void addSkillToAssociate(int associateId, Skill skill) {
        for (Associates associate : associates) {
            if (associate.getId() == associateId) {
                associate.addSkill(skill);
                break;
            }
        }
    }

    public void editSkill(int skillId, Skill updatedSkill) {
        for (Skill skill : skills) {
            if (skill.getId() == skillId) {
                skill.setName(updatedSkill.getName());
                skill.setDescription(updatedSkill.getDescription());
                skill.setCategory(updatedSkill.getCategory());
                skill.setExperience(updatedSkill.getExperience());
                break;
            }
        }
        for (Associates associate : associates) {
            associate.editSkill(skillId, updatedSkill);
        }
    }

    public void deleteSkill(int skillId) {
        skills.removeIf(skill -> skill.getId() == skillId);
        for (Associates associate : associates) {
            associate.deleteSkill(skillId);
        }
    }

    public void viewAssociate(int associateId){
        for (Associates associate : associates) {
            if (associate.getId() == associateId) {
                associate.viewDetails();
            }
        }
    }

    public void searchAssociateByName(String name){
        List<Associates> associatesByName = associates.stream()
                .filter(associate -> associate.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        for (Associates associate : associatesByName) {
            associate.viewDetails();
        }
    }

    public void searchAssociateByLocation(String location){
        List<Associates> associatesByLocation = associates.stream()
                .filter(associate -> associate.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        for (Associates associate : associatesByLocation) {
            associate.viewDetails();
        }
    }

    public void searchAssociateBySkills(String skillName){
        List<Associates> associatesBySkills =  associates.stream()
                .filter(associate -> associate.getSkills().stream()
                        .anyMatch(skill -> skill.getName().equalsIgnoreCase(skillName)))
                .collect(Collectors.toList());
        for (Associates associate : associatesBySkills) {
            associate.viewDetails();
        }
    }

    public void getTotalAssociates() {
        System.out.println("the total associates are : "+associates.size());
    }

    public void getTotalAssociatesWithSkillsGreaterThan(int n) {
        int count = (int) associates.stream()
                .filter(associate -> associate.getSkills().size() > n)
                .count();
        System.out.println("total associates with grater than "+n+" skills are : "+count);
    }

    public void getAssociateIdsWithSkillsGreaterThan(int n) {
        List<Integer> associateIdsWithSkillsGreaterThan = associates.stream()
                .filter(associate -> associate.getSkills().size() > n)
                .map(Associates::getId)
                .collect(Collectors.toList());
        System.out.println("associate id's with skills graterthan "+n+" skills are");
        for (int associate : associateIdsWithSkillsGreaterThan) {
            System.out.println(associate);
        }

    }

    public void getTotalAssociatesWithSkills(String requiredSkills) {
        int totalAssociatesWithSkills =  (int) associates.stream()
                .filter(associate -> associate.getSkills().stream()
                        .anyMatch(skill -> skill.getName().equalsIgnoreCase(requiredSkills)))
                .count();
        System.out.println("total associates with given skill are : "+totalAssociatesWithSkills);
    }
}
