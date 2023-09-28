package com.indium.capstone.Service;

import com.indium.capstone.Model.Associates;
import com.indium.capstone.Model.Skill;

public interface AssociateSkills  {
    void addAssociate(Associates associates);

    public void listAssociates();
    public void editAssociate(int associateId, Associates updatedAssociate);
    public void deleteAssociate(int associateId);
    public void addSkillToAssociate(int associateId, Skill skill);
    public void editSkill(int skillId, Skill updatedSkill);
    public void deleteSkill(int skillId);
    public void searchAssociateByName(String name);
    public void searchAssociateByLocation(String location);
    public void searchAssociateBySkills(String skillName);
    public void getTotalAssociates();
    public void getTotalAssociatesWithSkillsGreaterThan(int n);
    public void getAssociateIdsWithSkillsGreaterThan(int n);
    public void getTotalAssociatesWithSkills(String requiredSkills);
}
