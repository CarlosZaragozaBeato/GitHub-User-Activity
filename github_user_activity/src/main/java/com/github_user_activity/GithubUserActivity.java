package com.github_user_activity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GithubUserActivity {
    
    public GithubUserActivity() {
        // Constructor
    }
    
    public void getActivity(String user) {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Request rq = new Request.Builder()
                .url("https://api.github.com/users/" + user + "/events")
                .build();

        try (Response response = client.newCall(rq).execute()) {
            if (response.isSuccessful()) {
                // Deserialize the JSON into a List of Event objects
                List<Event> events = mapper.readValue(response.body().string(),
                        mapper.getTypeFactory().constructCollectionType(List.class, Event.class));

                // Process and print events
                for (Event event : events) {
                    // Only print the necessary fields
                    switch (event.getType()) {
                        case "PushEvent":
                            System.out.println("Pushed " + event.getPayload().getSize() + " commits to " + event.getRepo().getName());
                            break;
                        case "IssuesEvent":
                            System.out.println("Opened a new issue in " + event.getRepo().getName());
                            break;
                        case "WatchEvent":
                            System.out.println("Starred " + event.getRepo().getName());
                            break;
                        // Add other event types here if needed
                    }
                }
            } else {
                System.out.println("Request failed with code: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Make the Event class static
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Event {
        private String id;
        private String type;
        private Actor actor;
        private Repo repo;
        private Payload payload;
        private boolean isPublic;
        private String createdAt;

        @JsonProperty("public")
        public boolean isPublic() {
            return isPublic;
        }

        public void setIsPublic(boolean isPublic) {
            this.isPublic = isPublic;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Actor getActor() {
            return actor;
        }

        public void setActor(Actor actor) {
            this.actor = actor;
        }

        public Repo getRepo() {
            return repo;
        }

        public void setRepo(Repo repo) {
            this.repo = repo;
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Actor {
        private long id;
        private String login;
        private String displayLogin;
        private String gravatarId;  // Add this line
        private String url;
        private String avatarUrl;

        @JsonProperty("display_login")
        public String getDisplayLogin() {
            return displayLogin;
        }

        public void setDisplayLogin(String displayLogin) {
            this.displayLogin = displayLogin;
        }

        // Getters and Setters
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getGravatarId() {
            return gravatarId;
        }

        public void setGravatarId(String gravatarId) {
            this.gravatarId = gravatarId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Repo {
        private long id;
        private String name;
        private String url;

        // Getters and Setters
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Payload {
        private long repositoryId;
        private long pushId;
        private int size;
        private int distinctSize;
        private String ref;
        private String head;
        private String before;
        private List<Commit> commits;

        @JsonProperty("repository_id")
        public long getRepositoryId() {
            return repositoryId;
        }

        public void setRepositoryId(long repositoryId) {
            this.repositoryId = repositoryId;
        }

        public long getPushId() {
            return pushId;
        }

        public void setPushId(long pushId) {
            this.pushId = pushId;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getDistinctSize() {
            return distinctSize;
        }

        public void setDistinctSize(int distinctSize) {
            this.distinctSize = distinctSize;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getBefore() {
            return before;
        }

        public void setBefore(String before) {
            this.before = before;
        }

        public List<Commit> getCommits() {
            return commits;
        }

        public void setCommits(List<Commit> commits) {
            this.commits = commits;
        }
    }

    public static class Commit {
        private String sha;
        private Author author;
        private String message;
        private boolean distinct;
        private String url;

        // Getters and Setters
        public String getSha() {
            return sha;
        }

        public void setSha(String sha) {
            this.sha = sha;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isDistinct() {
            return distinct;
        }

        public void setDistinct(boolean distinct) {
            this.distinct = distinct;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Author {
        private String email;
        private String name;

        // Getters and Setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
