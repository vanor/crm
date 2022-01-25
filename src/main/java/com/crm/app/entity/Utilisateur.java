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
@Table(name = "user")
public class Utilisateur implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login", nullable = false, length = 255)
    private String login;

    @Column(name = "password", nullable = false, length = 255)
    private String password;


    @Column(name = "username", nullable = true, length = 255)
    private String username;

    @Column(name = "enabled")
    private boolean enabled = true;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Column(name = "type", nullable = true, length = 255)
    private String type;

    @Column(name = "tel", nullable = true, length = 255)
    private String tel;

    @Column(name = "token", nullable = true, length = 255)
    private String token;

    @Column(name = "expiretokendate", nullable = true, length = 255)
    private Date expireTokenDate;


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

    @Column(name = "role", nullable = true, length = 200)
    private String role;

    @Column(name = "fcmtoken", nullable = true)
    private String fcmToken;

    @Transient
    private Boolean canServeSite;

    @Transient
    private Boolean canChekUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_role", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id", nullable = false))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_permission", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "permissionid", referencedColumnName = "id", nullable = false))
    private Set<Permission> permissions;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_groupe", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "groupeid", referencedColumnName = "id", nullable = false))
    private Set<Groupe> groupes;

  

    @ManyToOne
    private Utilisateur supervisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTokenDate() {
        return expireTokenDate;
    }

    public void setExpireTokenDate(Date expireTokenDate) {
        this.expireTokenDate = expireTokenDate;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }


    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Boolean getCanServeSite() {
        return canServeSite;
    }

    public void setCanServeSite(Boolean canServeSite) {
        this.canServeSite = canServeSite;
    }

    public Boolean getCanChekUser() {
        return canChekUser;
    }

    public void setCanChekUser(Boolean canChekUser) {
        this.canChekUser = canChekUser;
    }


    public Utilisateur getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Utilisateur supervisor) {
        this.supervisor = supervisor;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type='" + type + '\'' +
                ", tel='" + tel + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", role='" + role + '\'' +
                ", fcmToken='" + fcmToken + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                ", groupes=" + groupes +
                ", supervisor=" + supervisor +
                '}';
    }


    public JSONObject toJSON() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("login", this.login);
        //jsonObject.put("password", this.getPassword());
        jsonObject.put("nom", this.nom);
        jsonObject.put("token", this.token);
        jsonObject.put("email", this.email);
        jsonObject.put("avatar", this.avatar);
        jsonObject.put("type", this.type);
        jsonObject.put("role", this.role);
        jsonObject.put("fcmToken", this.fcmToken);
        jsonObject.put("canServeSite", true);


        if(supervisor != null)
            jsonObject.put("supervisorLogin", supervisor.getLogin());
        else
            jsonObject.put("supervisorLogin", "");

        jsonObject.put("canChekUser", (this.role != null && (this.role.equals("admin") || this.role.equals("superviseur"))));
        // jsonObject.put("groupes", (new Groupe()).listeToJSON(Lists.newArrayList(this.getGroupes())));

        //jsonObject.put("groupeId", "5");
        jsonObject.put("permissions", new ArrayList());
        jsonObject.put("createdAt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt() != null ? this.getCreatedAt() : ""));
        return jsonObject;
    }

    public Map<String, Object> toMap() {

        Map<String, Object> jsonObject = new HashMap<String, Object>();
        ;
        jsonObject.put("id", this.id);
        jsonObject.put("login", this.login);
        //jsonObject.put("password", this.getPassword());
        jsonObject.put("nom", this.nom);
        jsonObject.put("token", this.token);
        jsonObject.put("email", this.email);
        jsonObject.put("avatar", this.avatar);
        jsonObject.put("type", this.type);
        jsonObject.put("role", this.role);
        jsonObject.put("fcmToken", this.fcmToken);
        jsonObject.put("canServeSite", true);


        jsonObject.put("tel", tel);
        jsonObject.put("enabled", enabled);

        if(this.supervisor != null){
            jsonObject.put("supervisorLogin", supervisor.getLogin());
            jsonObject.put("supervisorId", supervisor.getId());
        }else
            jsonObject.put("supervisorLogin", "");

        jsonObject.put("canChekUser", (this.role != null && (this.role.equals("admin") || this.role.equals("superviseur"))));
        // jsonObject.put("groupes", (new Groupe()).listeToJSON(Lists.newArrayList(this.getGroupes())));

        //jsonObject.put("groupeId", "5");
        jsonObject.put("permissions", new ArrayList());
        jsonObject.put("createdAt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreatedAt() != null ? this.getCreatedAt() : ""));
        return jsonObject;
    }


    public List<Map<String, Object>> listeToMap(List<Utilisateur> utilisateurDTOS) {
        List<Map<String, Object>> datas = new ArrayList<>();
        for (Utilisateur utilisateurDTO : utilisateurDTOS) {
            //try {
            datas.add(utilisateurDTO.toMap());
            /*} catch (JSONException e) {
                e.printStackTrace();
            }*/
        }

        return datas;
    }

    public Map<String, Object> toMap2() {

        Map<String, Object> jsonObject = new HashMap<String, Object>();
        jsonObject.put("id", this.id);
        return jsonObject;
    }

    public JSONArray listeToJSON(List<Utilisateur> utilisateurDTOS) {
        JSONArray datas = new JSONArray();
        for (Utilisateur utilisateurDTO : utilisateurDTOS) {
            try {
                datas.put(utilisateurDTO.toJSON());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return datas;
    }

    public Utilisateur httpServletRequestToReporting(HttpServletRequest request) {
        if (request.getParameter("login") != null && (request.getParameter("password") != null || request.getParameter("id") != null)
                && request.getParameter("nom") != null && request.getParameter("email") != null
        ) {

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setLogin(request.getParameter("login"));
            utilisateur.setNom(request.getParameter("nom"));
            utilisateur.setEmail(request.getParameter("email"));

            if (request.getParameter("password") != null)
                utilisateur.setPassword(request.getParameter("password"));


            utilisateur.setUsername(request.getParameter("login"));
            utilisateur.setTel(request.getParameter("tel"));

            if (request.getParameter("id") != null) {
                utilisateur.setId(Long.parseLong(request.getParameter("id")));
                utilisateur.setUpdatedAt(new Date());
            } else
                utilisateur.setCreatedAt(new Date());

            if (request.getParameter("actif") != null) {
                utilisateur.setEnabled(Integer.parseInt(request.getParameter("actif")) == 1);
            }


            if(request.getParameter("role") != null && !request.getParameter("role").isEmpty())
                utilisateur.setRole(request.getParameter("role"));

            return utilisateur;
        }

        return null;
    }


}
