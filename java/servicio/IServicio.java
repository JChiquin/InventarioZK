package servicio;

import DTO.Cliente;
import DTO.Factura;
import DTO.Historial;
import DTO.Perfil;
import DTO.Proveedor;
import DTO.Producto;
import DTO.Usuario;
import java.util.List;

import dao.IHibernateDAO;

public abstract interface IServicio {

	public void guardarProducto(Producto producto) throws Exception;
	public void setHibernateDAO(IHibernateDAO hibernateDAO);
        
	public Cliente buscarClientePorCedula(String cedula) throws Exception;
        public void guardarCliente(Cliente cliente) throws Exception;
	public List buscarClientesTodos() throws Exception;
	public void eliminarCliente(Cliente cliente) throws Exception;
        
        public Proveedor buscarProveedorPorRif(String rif) throws Exception;
        public void guardarProveedor(Proveedor proveedor) throws Exception;
	public List buscarProveedoresTodos() throws Exception;
	public void eliminarProveedor(Proveedor proveedor) throws Exception;
        
        public Usuario buscarUsuarioPorUsuario(String usuario) throws Exception;
        public void guardarUsuario(Usuario usuario) throws Exception;
	public List buscarUsuarioTodos() throws Exception;
	public void eliminarUsuario(Usuario usuario) throws Exception;
        
        public Factura buscarFacturaPorID(String factura) throws Exception;
        public void guardarFactura(Factura factura) throws Exception;
	public List buscarFacturaTodos() throws Exception;
	public void eliminarFactura(Factura factura) throws Exception;
        
        public Producto buscarProductoPorCodigo(String codigo) throws Exception;
	public List buscarProductoTodos() throws Exception;
	public void eliminarProducto(Producto producto) throws Exception;
        
        public Historial buscarHistorialPorCodigo(int id) throws Exception;
        public void guardarHistorial(Historial historial) throws Exception;
	public List buscarHistorialTodos() throws Exception;
        public List buscarHistorialPorProducto(String sql) throws Exception;
	public void eliminarHistorial(Historial historial) throws Exception;
        
        public Perfil buscarPerfil();
        public void guardarPerfil(Perfil perfil) throws Exception;
}
