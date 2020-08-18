//package com.learning.restfullapi.dao;
//
//import com.learning.restfullapi.model.Posts;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Repository("fakeDao")
//public class FakeDB implements PersonDao {
//
//    private static List<Posts> DB = new ArrayList<>();
//
//    @Override
//    public int insertPerson(UUID id, Posts posts) {
//        DB.add(new Posts(id, posts.getName()));
//        return 1;
//    }
//
//    @Override
//    public List<Posts> getALlPeople() {
//        return DB;
//    }
//
//    @Override
//    public Posts getPersonById(UUID id) {
//        for (Posts p: DB) {
//            if(p.getId().equals(id)) {
//                return p;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int deletePersonById(UUID id) {
//        Posts p = getPersonById(id);
//        if(p != null) {
//            DB.remove(p);
//            return 1;
//        }
//        return 0;
//    }
//
//    // to check it, because youtuber does not do such thing, only DB.set(index, newPerson)
//    // which does not work, because newPerson does not have specific id, because it is not initialized
//    // only casted form JSON data
//    @Override
//    public void updatePersonById(UUID id, Posts newPosts) {
//        Posts posts = getPersonById(id);
//
//        posts.setName(newPosts.getName());
//    }
//
//}
