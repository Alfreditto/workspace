package prueba;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "empleados", schema = "ejemplo", catalog = "")
public class EmpleadosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_no")
    private short empNo;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "oficio")
    private String oficio;
    @Basic
    @Column(name = "dir")
    private Short dir;
    @Basic
    @Column(name = "fecha_alt")
    private Date fechaAlt;
    @Basic
    @Column(name = "salario")
    private Double salario;
    @Basic
    @Column(name = "comision")
    private Double comision;
    @Basic
    @Column(name = "dept_no")
    private byte deptNo;

    public short getEmpNo() {
        return empNo;
    }

    public void setEmpNo(short empNo) {
        this.empNo = empNo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Short getDir() {
        return dir;
    }

    public void setDir(Short dir) {
        this.dir = dir;
    }

    public Date getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public byte getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(byte deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadosEntity that = (EmpleadosEntity) o;

        if (empNo != that.empNo) return false;
        if (deptNo != that.deptNo) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (oficio != null ? !oficio.equals(that.oficio) : that.oficio != null) return false;
        if (dir != null ? !dir.equals(that.dir) : that.dir != null) return false;
        if (fechaAlt != null ? !fechaAlt.equals(that.fechaAlt) : that.fechaAlt != null) return false;
        if (salario != null ? !salario.equals(that.salario) : that.salario != null) return false;
        if (comision != null ? !comision.equals(that.comision) : that.comision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) empNo;
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (oficio != null ? oficio.hashCode() : 0);
        result = 31 * result + (dir != null ? dir.hashCode() : 0);
        result = 31 * result + (fechaAlt != null ? fechaAlt.hashCode() : 0);
        result = 31 * result + (salario != null ? salario.hashCode() : 0);
        result = 31 * result + (comision != null ? comision.hashCode() : 0);
        result = 31 * result + (int) deptNo;
        return result;
    }
}
