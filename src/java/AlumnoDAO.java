
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    
    
    //CONEXION A LA BD
    public static Connection getConnection() {

        Connection con = null;
        String url = "jdbc:derby://localhost:1527/Alumnos";
        String user = "Reyes";
        String pass = "1234";

        Driver driver = new org.apache.derby.jdbc.ClientDriver();

        try {
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    //GUARDAR
    public static int save(Alumnos e) {
        int status = 0;
        try {
            Connection con = AlumnoDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into ALUMNO(NUMEROCONTROL,NOMBRE,CURSO,SEMESTRE) values (?,?,?,?)");
            ps.setString(1, e.getNumeroControl());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getCurso());
            ps.setString(4, e.getSemestre());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

     //VER
    public static List<Alumnos> getAllAlumnos() {
        List<Alumnos> list = new ArrayList<Alumnos>();

        try {
            Connection con = AlumnoDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ALUMNO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumnos e = new Alumnos();
                e.setNumeroControl(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setCurso(rs.getString(3));
                e.setSemestre(rs.getString(4));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

     //ELIMINAR
    public static int delete(String numeroC) {
        int status = 0;
        try {
            Connection con = AlumnoDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from ALUMNO where NUMEROCONTROL=?");
            ps.setString(1, numeroC);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

     //Ver Alumno por Numero de Control
    public static Alumnos getAlumnoByNumeroC(String numeroC) {
        Alumnos e = new Alumnos();

        try {
            Connection con = AlumnoDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ALUMNO where NUMEROCONTROL=?");
            ps.setString(1,numeroC);  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setNumeroControl(rs.getString(1));
                e.setNombre(rs.getString(2));
                e.setCurso(rs.getString(3));
                e.setSemestre(rs.getString(4));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    
    
    //MODIFICAR
    
     public static int update(Alumnos e){  
        int status=0;  
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update ALUMNO set NOMBRE=?,CURSO=?,SEMESTRE=? where NUMEROCONTROL=?");  
            ps.setString(1,e.getNombre());  
            ps.setString(2,e.getCurso());  
            ps.setString(3,e.getSemestre());  
            ps.setString(4,e.getNumeroControl());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  

}
