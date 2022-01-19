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
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "guardname", nullable = true, length = 255)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_has_permission", joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "permissionid", referencedColumnName = "id", nullable = false))
    private Set<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
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

    public void setCreatedAt(Date createdAt) {
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


    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Utilisateur> getUsers() {
        return Users;
    }

    public void setUsers(Set<Utilisateur> users) {
        Users = users;
    }


    public JSONObject toJSON() throws JSONException {
        System.out.println(" to json ");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("name", this.name);
        jsonObject.put("description", this.description);
        jsonObject.put("createdAt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt() != null ? this.getCreatedAt() : ""));

        System.out.println(" avant ");
        Set<Permission> permissions = this.permissions;

        // List<Permission> permissions = Lists.newArrayList(this.getPermissions());
        System.out.println(" après ");
        if (permissions != null && permissions.size() > 0) {
            System.out.println(" plus 1 perm ");
            jsonObject.put("permissions", (new Permission()).listeToJSON(Lists.newArrayList(permissions)));
            System.out.println(" after perm perm ");
        } else {
            System.out.println(" no perm ");
            jsonObject.put("permissions", new ArrayList());
            System.out.println(" after perm perm ");
        }

        return jsonObject;
    }


    public Map<String, Object> toMap()  {

        Map<String, Object> jsonObject = new HashMap<String, Object>();
        jsonObject.put("id", this.id);
        jsonObject.put("name", this.name);
        jsonObject.put("description", this.description);
        jsonObject.put("createdAt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt() != null ? this.getCreatedAt() : ""));

        System.out.println(" avant ");
        Set<Permission> permissions = this.permissions;

        // List<Permission> permissions = Lists.newArrayList(this.getPermissions());
        System.out.println(" après ");
        if (permissions != null && permissions.size() > 0) {

            System.out.println(" plus 1 perm ");
            jsonObject.put("permissions", (new Permission()).listeToMap(Lists.newArrayList(permissions)));
            System.out.println(" after perm perm ");

        } else {
            System.out.println(" no perm ");
            jsonObject.put("permissions", new ArrayList());
            System.out.println(" after perm perm ");
        }

        return jsonObject;
    }


    public  List<Map<String, Object>> listeToMap(List<Role> roles) {

        List<Map<String, Object>> datas = new ArrayList<>();


        for (Role role : roles) {

                datas.add(role.toMap());

        }

        return datas;
    }


    public JSONArray listeToJSON(List<Role> roles) {
        JSONArray datas = new JSONArray();
        for (Role role : roles) {
            try {
                datas.put(role.toJSON());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return datas;
    }


    public Role httpServletRequestToRole(HttpServletRequest request) {
        if (request.getParameter("name") != null && request.getParameter("description") != null

        ) {
            Role role = new Role();
            role.setName(request.getParameter("name"));
            role.setDescription(request.getParameter("description"));
            role.setCreatedAt(new Date());
            role.setUpdatedAt(new Date());

            if(request.getParameter("id") != null)
                role.setId(Long.parseLong(request.getParameter("id")));


            return role;
        }

        return null;
    }

}
