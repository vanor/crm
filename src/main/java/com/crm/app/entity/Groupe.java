package com.crm.app.entity;

import com.google.common.collect.Lists;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "groupe")
public class Groupe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "createdat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "deletedat", nullable = true)
    private Date deletedAt;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_groupe", joinColumns = @JoinColumn(name = "groupeid", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false))
    private Set<Utilisateur> Users;

    @Transient
    private String userids; // ide des users separéspar les ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }


    public Set<Utilisateur> getUsers() {
        return Users;
    }

    public void setUsers(Set<Utilisateur> users) {
        Users = users;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserids() {
        return userids;
    }

    public void setUserids(String userids) {
        this.userids = userids;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("id", this.getId());
        jo.put("nom", this.getNom());
        jo.put("description", this.getDescription());

        Set<Utilisateur> utilisateurs = this.getUsers();
        if(utilisateurs != null && utilisateurs.size() > 0) {
            jo.put("nombre_compte", utilisateurs.size());
        }else{
            jo.put("nombre_compte", 0);
        }
        jo.put("createdAt",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt() != null ? this.getCreatedAt() : ""));
       // jo.put("users", (new Utilisateur()).listeToJSON(Lists.newArrayList(this.getUsers())));
        return jo;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> jo = new HashMap<String, Object>();
        jo.put("id", this.getId());
        jo.put("nom", this.getNom());
        jo.put("description", this.getDescription());

        Set<Utilisateur> utilisateurs = this.getUsers();
        if(utilisateurs != null && utilisateurs.size() > 0) {
            jo.put("nombre_compte", utilisateurs.size());
        }else{
            jo.put("nombre_compte", 0);
        }
        jo.put("createdAt",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt() != null ? this.getCreatedAt() : ""));
       // jo.put("users", (new Utilisateur()).listeToJSON(Lists.newArrayList(this.getUsers())));
        return jo;
    }



    public List<Map<String, Object>> listeToMap(List<Groupe> groupes) {
        List<Map<String, Object>> datas = new ArrayList<>();

        for (Groupe groupe : groupes) {

                datas.add(groupe.toMap());

        }

        return datas;
    }


     public JSONArray listeToJSON(List<Groupe> groupes) {
        JSONArray datas = new JSONArray();
        for (Groupe groupe : groupes) {
            try {
                datas.put(groupe.toJSON());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return datas;
    }



    public Groupe httpServletRequestToReporting(HttpServletRequest request) {
        if (request.getParameter("nom") != null && request.getParameter("description") != null
           ) {

            Groupe groupe = new Groupe();
            groupe.setDescription(request.getParameter("description"));
            groupe.setNom(request.getParameter("nom"));
            groupe.setCreatedAt(new Date());
            groupe.setUpdatedAt(new Date());

            if(request.getParameter("id") != null)
                groupe.setId(Long.parseLong(request.getParameter("id")));


            return groupe;
        }

        return null;
    }

}
