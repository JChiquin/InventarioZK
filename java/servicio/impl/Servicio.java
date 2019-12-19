package servicio.impl;

import DTO.Cliente;
import DTO.Factura;
import DTO.Historial;
import DTO.Perfil;
import DTO.Producto;
import DTO.Proveedor;
import DTO.Usuario;
import java.util.List;

import dao.IHibernateDAO;
import servicio.IServicio;

public class Servicio implements IServicio {

    IHibernateDAO hibernateDAO;

    public IHibernateDAO getHibernateDAO() {
        return hibernateDAO;
    }

    public void setHibernateDAO(IHibernateDAO hibernateDAO) {
        this.hibernateDAO = hibernateDAO;
    }

    @Override
    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente.getCedula() == null || cliente.getCedula().trim().equals("")) {
            throw new Exception("Debe Insertar La Cedula");
        }
        hibernateDAO.saveOrUpdate(cliente);
    }

    @Override
    public Cliente buscarClientePorCedula(String cedula) {
        return (Cliente) hibernateDAO.findByKey(Cliente.class, cedula);
    }

    @Override
    public List buscarClientesTodos() {
        return hibernateDAO.loadAll(Cliente.class);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        hibernateDAO.delete(cliente);
    }

    @Override
    public void guardarProducto(Producto producto) throws Exception {
        hibernateDAO.saveOrUpdate(producto);
    }

    @Override
    public Proveedor buscarProveedorPorRif(String rif) throws Exception {
        return (Proveedor) hibernateDAO.findByKey(Proveedor.class, rif);
    }

    @Override
    public void guardarProveedor(Proveedor proveedor) throws Exception {
        hibernateDAO.saveOrUpdate(proveedor);
    }

    @Override
    public List buscarProveedoresTodos() throws Exception {
        return hibernateDAO.loadAll(Proveedor.class);
    }

    @Override
    public void eliminarProveedor(Proveedor proveedor) throws Exception {
        hibernateDAO.delete(proveedor);
    }

    @Override
    public Usuario buscarUsuarioPorUsuario(String usuario) throws Exception {
        return (Usuario) hibernateDAO.findByKey(Usuario.class, usuario);
    }

    @Override
    public void guardarUsuario(Usuario usuario) throws Exception {
        hibernateDAO.saveOrUpdate(usuario);
    }

    @Override
    public List buscarUsuarioTodos() throws Exception {
        return hibernateDAO.loadAll(Usuario.class);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws Exception {
        hibernateDAO.delete(usuario);
    }
    @Override
    public Perfil buscarPerfil() {
       return (Perfil)hibernateDAO.loadAll(Perfil.class).get(0);
    }

    @Override
    public void guardarPerfil(Perfil perfil) throws Exception {
        hibernateDAO.saveOrUpdate(perfil);
    }

    @Override
    public Factura buscarFacturaPorID(String factura) throws Exception {
        return (Factura) hibernateDAO.findByKey(Factura.class, factura);
    }

    @Override
    public void guardarFactura(Factura factura) throws Exception {
       hibernateDAO.saveOrUpdate(factura);
    }

    @Override
    public List buscarFacturaTodos() throws Exception {
        return hibernateDAO.loadAll(Factura.class);
    }

    @Override
    public void eliminarFactura(Factura factura) throws Exception {
        hibernateDAO.delete(factura);
    }
    
    @Override
    public Producto buscarProductoPorCodigo(String codigo) throws Exception {
        return (Producto) hibernateDAO.findByKey(Producto.class, codigo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscarProductoTodos() throws Exception {
        return hibernateDAO.loadAll(Producto.class); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarProducto(Producto producto) throws Exception {
        hibernateDAO.delete(producto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Historial buscarHistorialPorCodigo(int id) throws Exception {
        return (Historial) hibernateDAO.findByKey(Historial.class, id);  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardarHistorial(Historial historial) throws Exception {
        hibernateDAO.saveOrUpdate(historial); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscarHistorialTodos() throws Exception {
         return hibernateDAO.loadAll(Historial.class);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarHistorial(Historial historial) throws Exception {
         hibernateDAO.delete(historial); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List buscarHistorialPorProducto(String sql) throws Exception {
        return hibernateDAO.findBySQLQuery(sql ); //To change body of generated methods, choose Tools | Templates.
    }


}
