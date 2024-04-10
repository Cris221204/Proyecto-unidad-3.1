import java.util.ArrayList;

public class Administrator extends User {
    public ArrayList<Permissions> permissions = new ArrayList<Permissions>();
    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }
    boolean isSuperAdmin;

    public ArrayList<Permissions> getPermissions() {
        return this.permissions;
    }


    public void addPermissions(){
        permissions.add(Permissions.DELETE);
        permissions.add(Permissions.READ);
        permissions.add(Permissions.WRITE);
    }
    public Administrator(Profile profile, String username, String password, boolean isSuperAdmin) {
        super(profile, username, password);
        this.isSuperAdmin = isSuperAdmin;
    }

}