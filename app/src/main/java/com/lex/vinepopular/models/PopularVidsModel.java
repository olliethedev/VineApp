package com.lex.vinepopular.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by Oleksiy on 1/30/2016.
 */
public class PopularVidsModel
{

    public String code;
    public Data data;
    public boolean success;
    public String error;


    @Override
    public String toString() {
        return "PopularVids{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", success=" + success +
                ", error='" + error + '\'' +
                '}';
    }

    public class Loops
    {
        public int count;
        public double velocity;
        public int onFire;
    }

    public class Comments
    {
        public int count;
        public String anchorStr;
        public List<Record> records;
        public String previousPage;
        public String backAnchor;
        public String anchor;
        public String nextPage;
        public int size;
    }

    public class Entity
    {
        public List<String> vanityUrls;
        public String title;
        public List<Integer> range;
        public String link;
        public String type;
        public Object id;
    }

    public class Reposts
    {
        public int count;
        public String anchorStr;
        public List<Record> records;
        public String previousPage;
        public String backAnchor;
        public String anchor;
        public String nextPage;
        public int size;
    }

    public class User
    {
        @SerializedName("private")
        public int privateNum;
    }

    public class Likes
    {
        public int count;
        public String anchorStr;
        public List<Record> records;
        public String previousPage;
        public String backAnchor;
        public Object anchor;
        public int nextPage;
        public int size;
    }

    public class Record
    {
        public int liked;
        public String videoDashUrl;
        public String foursquareVenueId;
        public Object userId;
        @SerializedName("private")
        public int privateNum;
        public String videoWebmUrl;
        public Loops loops;
        public String thumbnailUrl;
        public int explicitContent;
        public int blocked;
        public int verified;
        public String avatarUrl;
        public Comments comments;
        public List<Entity> entities;
        public String videoLowURL;
        public List<String> vanityUrls;
        public String username;
        public String description;
        public List<Object> tags;
        public String permalinkUrl;
        public int promoted;
        public Object postId;
        public String profileBackground;
        public String videoUrl;
        public int followRequested;
        public String created;
        public int hasSimilarPosts;
        public String shareUrl;
        public int myRepostId;
        public int following;
        public Reposts reposts;
        public Likes likes;

        @Override
        public String toString() {
            return "Record{" +
                    "liked=" + liked +
                    ", videoDashUrl='" + videoDashUrl + '\'' +
                    ", foursquareVenueId='" + foursquareVenueId + '\'' +
                    ", userId=" + userId +
                    ", privateNum=" + privateNum +
                    ", videoWebmUrl='" + videoWebmUrl + '\'' +
                    ", loops=" + loops +
                    ", thumbnailUrl='" + thumbnailUrl + '\'' +
                    ", explicitContent=" + explicitContent +
                    ", blocked=" + blocked +
                    ", verified=" + verified +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    ", comments=" + comments +
                    ", entities=" + entities +
                    ", videoLowURL='" + videoLowURL + '\'' +
                    ", vanityUrls=" + vanityUrls +
                    ", username='" + username + '\'' +
                    ", description='" + description + '\'' +
                    ", tags=" + tags +
                    ", permalinkUrl='" + permalinkUrl + '\'' +
                    ", promoted=" + promoted +
                    ", postId=" + postId +
                    ", profileBackground='" + profileBackground + '\'' +
                    ", videoUrl='" + videoUrl + '\'' +
                    ", followRequested=" + followRequested +
                    ", created='" + created + '\'' +
                    ", hasSimilarPosts=" + hasSimilarPosts +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", myRepostId=" + myRepostId +
                    ", following=" + following +
                    ", reposts=" + reposts +
                    ", likes=" + likes +
                    '}';
        }
    }

    public class Data {
        public int count;
        public String anchorStr;
        public List<Record> records;
        public String previousPage;
        public String backAnchor;
        public String anchor;
        public int nextPage;
        public int size;

        @Override
        public String toString() {
            return "Data{" +
                    "count=" + count +
                    ", anchorStr='" + anchorStr + '\'' +
                    ", records=" + records +
                    ", previousPage='" + previousPage + '\'' +
                    ", backAnchor='" + backAnchor + '\'' +
                    ", anchor='" + anchor + '\'' +
                    ", nextPage=" + nextPage +
                    ", size=" + size +
                    '}';
        }
    }
}
