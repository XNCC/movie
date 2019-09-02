package ncc.movie.movie.pojo;

public class actorBean {
    int actor_id;
    String actor_name;
    String directors;

    public actorBean() {
    }

    @Override
    public String toString() {
        return "actorBean{" +
                "actor_id=" + actor_id +
                ", actor_name='" + actor_name + '\'' +
                ", directors='" + directors + '\'' +
                '}';
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
}
