package ir.co.arca.twitter;

import java.util.List;

public class User {

    String _id="";
    String name="";
    String bio="";
    List<Follow> followers;
    List<Follow> followings;

//      "_id": "5cfe81cab38bd43d10847659",
//              "fullname": "Hassan Akbari",
//              "username": "hasan",
//              "password": "$2b$10$MFkDVw8fJ3M9cSqRkTvn7upkIwczrUdpRf.M4Jmb4oCRbfoQZm3kW",
//              "bio": "this is bio .",
//              "email": "hasan@mail.com",
//              "regdate": "2019-06-10T16:14:02.502Z",
//              "following": [
//    {
//        "twitter": "5d00a356837556337cbba999",
//            "followingDate": "2019-06-12T08:00:19.987Z",
//            "_id": "5d00b11383207824d45aacf4",
//            "username": "jamshid"
//    }
//    ],
//            "follower": [
//    {
//        "twitter": "5cfe5c882d651e62d04ab670",
//            "followingDate": "2019-06-11T13:47:38.353Z",
//            "_id": "5cffb0fa46b82c4c2ce3586c",
//            "username": "alireza"
//    }
//    ],
//

}
class Follow{
    String _id="";
    String name="";
}