package com.crm.app.entity;

import com.google.common.collect.Lists;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "guardname", length = 255)
    private String guardName;

    @Column(name = "description", nullable = true)
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

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    @ManyToMany(mappedBy = "permissions")
    private Set<Utilisateur> Users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGuardName() {
        return guardName;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
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

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Set<Utilisateur> getUsers() {
        return Users;
    }

    public void setUsers(Set<Utilisateur> users) {
        Users = users;
    }


    public JSONObject toJSON() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("name", this.name);
        jsonObject.put("description", this.description);
        jsonObject.put("guardname", this.guardName);
        //jsonObject.put("createdAt", this.createdAt);

        return jsonObject;
    }


    public Map<String, Object> toMap() throws JSONException {
        Map<String, Object> jsonObject = new HashMap<String, Object>();

       // JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("name", this.name);
        jsonObject.put("description", this.description);
        jsonObject.put("guardname", this.guardName);
        //jsonObject.put("createdAt", this.createdAt);

        return jsonObject;
    }


    public   List<Map<String, Object>> listeToMap(List<Permission> permissionList) {

        List<Map<String, Object>> datas = new ArrayList<>();//new HashMap<String, Object>();
       // JSONArray datas = new JSONArray();
        for (Permission permission : permissionList) {
            try {
                datas.add(permission.toMap());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //System.out.println(" map "+);

        return datas;
    }


    public JSONArray listeToJSON(List<Permission> permissionList) {
        JSONArray datas = new JSONArray();
        for (Permission permission : permissionList) {
            try {
                datas.put(permission.toJSON());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return datas;
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", guardName=" + guardName + ", description=" + description
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", roles="
				+ roles + ", Users=" + Users + "]";
	}

    

}
