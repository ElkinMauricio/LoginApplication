/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Entidad.Usuario;
import Control.ValidarRegistro;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio
 */
public class TestRegistro {

    private static ValidarRegistro validarRegistro = new ValidarRegistro();
    private String LONG_NOMBRE_INCORRECTA = "longitud nombre incorrecto";
    private String LONG_PASSWORD_INCORRECTA = "longitud contraseña incorrecta";
    private String USUARIO_EXISTENTE = "Usuario ya existe";
    private String CONTRASEÑA_NO_COINCIDEN = "contraseñas no coinciden";
    private String USUARIO_VALIDADOS = "Usuario registrado";

    public TestRegistro() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();

        a.setNombre("Juan");
        a.setPassword("1234");
        b.setNombre("Pedro");
        b.setPassword("123");
        c.setNombre("Maria");
        c.setPassword("12345");

        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);

        sistema.setUsuarios(usuarios);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLongitudNombre() {
        Usuario u = new Usuario();
        String validarContraseña;
        u.setNombre("R");
        u.setPassword("123456");
        validarContraseña = ("123456");
        assertEquals(validarRegistro.verificarRegistro(u, validarContraseña), LONG_NOMBRE_INCORRECTA);
    }

    @Test
    public void testLongitudContraseña() {
        Usuario u = new Usuario();
        String validarContraseña;
        u.setNombre("Pepe");
        u.setPassword("12");
        validarContraseña = ("12");
        assertEquals(validarRegistro.verificarRegistro(u, validarContraseña), LONG_PASSWORD_INCORRECTA);
        u.setNombre("Pepe");
        u.setPassword("123456");
        validarContraseña = ("123456");
        assertEquals(validarRegistro.verificarRegistro(u, validarContraseña), LONG_PASSWORD_INCORRECTA);
    }

    @Test
    public void testExistenciaUsuario() {
        Usuario u = new Usuario();
        String validarContraseña;
        u.setNombre("Juan");
        u.setPassword("12234");
        validarContraseña = ("12234");
        assertEquals(validarRegistro.verificarRegistro(u, validarContraseña), USUARIO_EXISTENTE);
    }

    @Test
    public void testCoincidenciaPassword() {
        Usuario u = new Usuario();
        String validarContraseña;
        u.setNombre("jaime");
        u.setPassword("12234");
        validarContraseña = ("1234");
        assertEquals(validarRegistro.verificarRegistro(u, validarContraseña), CONTRASEÑA_NO_COINCIDEN);
    }

    @Test
    public void UsuariosValidos() {

        Usuario u = new Usuario();
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        String validarContraseña;
        u.setNombre("robert");
        u.setPassword("mipas");
        validarContraseña = ("mipas");
        assertEquals(validarRegistro.verificarRegistro(u, validarContraseña), USUARIO_VALIDADOS);

        a.setNombre("Gil");
        a.setPassword("123");
        validarContraseña = ("123");
        assertEquals(validarRegistro.verificarRegistro(a, validarContraseña), USUARIO_VALIDADOS);

        b.setNombre("jaime");
        b.setPassword("123");
        validarContraseña = ("123");
        assertEquals(validarRegistro.verificarRegistro(b, validarContraseña), USUARIO_VALIDADOS);

        c.setNombre("afk");
        c.setPassword("12345");
        validarContraseña = ("12345");
        assertEquals(validarRegistro.verificarRegistro(c, validarContraseña), USUARIO_VALIDADOS);

// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
    }
}
