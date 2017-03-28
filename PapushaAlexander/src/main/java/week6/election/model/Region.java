package week6.election.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 04.03.17.
 */
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(nullable = false)
    private String name;
    private int population;

    @OneToMany(mappedBy = "region", cascade = {CascadeType.PERSIST})
    private List<Candidate> candidateList = new ArrayList<>();


    public Region(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public Region() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
