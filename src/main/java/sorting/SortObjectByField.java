package sorting;

import java.util.Date;

public class SortObjectByField implements Comparable<SortObjectByField>{
        private long id;
        private String email;
        private Date createdOn;

        // other getters and setters omitted

        public Date getCreatedOn() {
          return createdOn;
        }

        public void setCreatedOn(Date createdOn) {
          this.createdOn = createdOn;
        }

        //Option-1
        @Override
        public int compareTo(SortObjectByField u) {
          if (getCreatedOn() == null || u.getCreatedOn() == null) {
            return 0;
          }
          return getCreatedOn().compareTo(u.getCreatedOn());
        }
        
        //option-2
        //Ascending Sort
//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User u1, User u2) {
//              return u1.getCreatedOn().compareTo(u2.getCreatedOn());
//            }
//          });
        
//        Descending sort
//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User u1, User u2) {
//              return u2.getCreatedOn().compareTo(u1.getCreatedOn());
//            }
//          });
        
        //Option-3
//        users.sort(Comparator.comparing(User::getCreatedOn));
//        users.sort(Comparator.comparing(User::getCreatedOn).reversed());
        
        //Option-4
//        Stream interface sorted() [Java 8]
        
//        List<User> sortedUsers = users.stream()
//                .sorted(Comparator.comparing(User::getCreatedOn))
//                .collect(Collectors.toList());
//        
//        List<User> sortedUsers = users.stream()
//                .sorted(Comparator.comparing(User::getCreatedOn).reversed())
//                .collect(Collectors.toList());
        
}
