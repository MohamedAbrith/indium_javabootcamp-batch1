import com.indium.capstone.Model.Associates;
import com.indium.capstone.Model.Skill;
import com.indium.capstone.Service.AssociateSkillTrack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AssociateSkillTrack app = new AssociateSkillTrack();
        Scanner scanner = new Scanner(System.in);
        int skillId =1;

        while (true) {
            System.out.println("Associate Skill Track");
            System.out.println("1)Add the Associates");
            System.out.println("2)List the Associates");
            System.out.println("3)Edit the Associate");
            System.out.println("4)Delete the Associate");
            System.out.println("5)Add Skill to the Associate");
            System.out.println("6)Edit the Skill");
            System.out.println("7)Delete the Skill");
            System.out.println("8)View the Associate Details");
            System.out.println("9)Search the  associates");
            System.out.println("10)show the key metrics");
            System.out.println("11)Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Associate id: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter the Associate Name: ");
                    String name = scanner.next();
                    System.out.print("Enter the Associate Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter the Business Unit: ");
                    String businessUnit = scanner.next();
                    System.out.print("Enter the  Email: ");
                    String email = scanner.next();
                    System.out.print("Enter the Location: ");
                    String location = scanner.next();
                    Associates newAssociate = new Associates(id,name, age, businessUnit, email, location);
                    app.addAssociate(newAssociate);
                    System.out.println("Associates added");
                    break;
                case 2:
                    System.out.println("List of the Associates:");
                    app.listAssociates();
                    break;
                case 3:
                    System.out.print("Enter the Associate ID to Edit: ");
                    int editAssociateId = scanner.nextInt();
                    System.out.print("Enter the Associate Name: ");
                    name = scanner.next();
                    System.out.print("Enter the Associate Age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter the Business Unit: ");
                    businessUnit = scanner.next();
                    System.out.print("Enter the Email: ");
                    email = scanner.next();
                    System.out.print("Enter the Location: ");
                    location = scanner.next();
                    Associates updatedAssociate = new Associates(editAssociateId,name, age, businessUnit, email, location);
                    app.editAssociate(editAssociateId, updatedAssociate);
                    System.out.println("Associates edited successfully");
                    break;
                case 4:
                    System.out.print("Enter the Associate ID to Delete: ");
                    int deleteAssociateId = scanner.nextInt();
                    app.deleteAssociate(deleteAssociateId);
                    System.out.println("Associate deleted successfully!");
                    break;
                case 5:
                    System.out.print("Enter the Associate ID to Add Skill: ");
                    int addSkillAssociateId = scanner.nextInt();
                    System.out.print("Enter the Skill Name: ");
                    String skillName = scanner.next();
                    System.out.print("Enter the Skill Description: ");
                    String skillDescription = scanner.next();
                    System.out.print("Enter the Skill Category (Primary/Secondary): ");
                    String skillCategory = scanner.next();
                    System.out.print("Enter the Skill Experience (months): ");
                    int skillExperience = scanner.nextInt();
                    Skill newSkill = new Skill(addSkillAssociateId,skillName, skillDescription, skillCategory, skillExperience);
                    app.addSkillToAssociate(addSkillAssociateId, newSkill);
                    System.out.println("Skill added to the associate successfully!");
                    skillId++;
                    break;
                case 6:
                    System.out.print("Enter the Skill ID to Edit: ");
                    int editSkillId = scanner.nextInt();
                    System.out.print("Enter the Skill Name: ");
                    skillName = scanner.next();
                    System.out.print("Enter the Skill Description: ");
                    skillDescription = scanner.next();
                    System.out.print("Enter the Skill Category (Primary/Secondary): ");
                    skillCategory = scanner.next();
                    System.out.print("Enter the Skill Experience (months): ");
                    skillExperience = scanner.nextInt();
                    Skill updatedSkill = new Skill(editSkillId,skillName, skillDescription, skillCategory, skillExperience);
                    app.editSkill(editSkillId, updatedSkill);
                    skillId++;
                    System.out.println("Skill edited successfully!");
                    break;
                case 7:
                    System.out.print("Enter the Skill ID to Delete: ");
                    int deleteSkillId = scanner.nextInt();
                    app.deleteSkill(deleteSkillId);
                    System.out.println("Skill the deleted successfully!");
                    break;
                case 8:
                    System.out.print("Enter the Associate ID to View Details: ");
                    int viewAssociateId = scanner.nextInt();
                    app.viewAssociate(viewAssociateId);
                    break;
                case 9:{
                    System.out.println("1)search associate by associate name");
                    System.out.println("2)search associate by associate id");
                    System.out.println("3)search associate by location");
                    System.out.println("4)search associate by skills");
                    int searchChoice = scanner.nextInt();
                    switch (searchChoice){
                        case 1 :{
                            System.out.println("Enter the associate name");
                            name = scanner.next();
                            app.searchAssociateByName(name);
                            break;
                        }
                        case 2:{
                            System.out.println("Enter the associate id");
                            viewAssociateId = scanner.nextInt();
                            app.viewAssociate(viewAssociateId);
                            break;
                        }
                        case 3 :{
                            System.out.println("Enter the location");
                            location = scanner.next();
                            app.searchAssociateByLocation(location);
                            break;
                        }
                        case 4:{
                            System.out.println("Enter the skill name");
                            skillName = scanner.next();
                            app.searchAssociateBySkills(skillName);
                            break;
                        }
                        default :
                            System.out.println("Exiting invalid option");
                            break;
                    }
                    break;
                }
                case 10:{
                    System.out.println("1)To find associates account");
                    System.out.println("2)To find associates count with grater than n skills");
                    System.out.println("3)To find associate id's with grater than n skills");
                    System.out.println("4)To find associates with particular skill");
                    choice  = scanner.nextInt();
                    switch (choice){
                        case 1:{
                            app.getTotalAssociates();
                            break;
                        }
                        case 2:{
                            System.out.println("Enter count of n : ");
                            int count = scanner.nextInt();
                            app.getTotalAssociatesWithSkillsGreaterThan(count);
                            break;
                        }
                        case 3:{
                            System.out.println("Enter count of n : ");
                            int count = scanner.nextInt();
                            app.getAssociateIdsWithSkillsGreaterThan(count);
                            break;
                        }
                        case 4:{
                            System.out.println("Enter the skill to search");
                            String skill = scanner.next();
                            app.getTotalAssociatesWithSkills(skill);
                            break;
                        }
                        default:{
                            System.out.println("Exiting due to wrong option");
                            break;
                        }
                    }
                    break;

                }
                case 0:
                    System.out.println("Exiting Skill Tracker App.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
