# BlogApp
##to customize the join table


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other fields and getters/setters

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // getter and setter for roles
}

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other fields and getters/setters

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    // getter and setter for users
}

@Entity
@Table(name = "user_role")
public class UserRole {
    @EmbeddedId
    private UserRoleKey id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // getter and setter for createdAt
}

@Embeddable
public class UserRoleKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // getters and setters for user and role
}




User user = new User();
Role role = new Role();
UserRole userRole = new UserRole();
userRole.setId(new UserRoleKey(user, role));
userRole.setCreatedAt(LocalDateTime.now());
user.getRoles().add(role);
userRepository.save(user);
