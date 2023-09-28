package com.indium.capstone.Dao;



import com.indium.capstone.Model.Skill;

import java.util.List;

public interface SkillDao {
    public Boolean create(Skill skill);
    public boolean update(Skill updatedSkill);
    public boolean delete(int skillID);
}
