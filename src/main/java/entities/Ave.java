package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "aves")
public class Ave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "kind")
    private String kind;

    @Column(name = "plumage")
    private String plumage;

    @Column(name = "habitat")
    private String habitat;


    public Ave() {
    }

    public Ave(String name, String kind, String plumage, String habitat) {
        this.name = name;
        this.kind = kind;
        this.plumage = plumage;
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getPlumage() {
        return plumage;
    }

    public void setPlumage(String plumage) {
        this.plumage = plumage;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ave{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
