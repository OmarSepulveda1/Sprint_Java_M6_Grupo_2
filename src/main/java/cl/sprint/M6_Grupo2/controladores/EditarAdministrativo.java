package cl.sprint.M6_Grupo2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Administrativo;
import cl.sprint.M6_Grupo2.modelos.service.AdministrativoServicio;

@Controller
public class EditarAdministrativo {

    @Autowired
    private AdministrativoServicio adminServ;

    @RequestMapping(value = "/EditarAdministrativo")
    public ModelAndView mostrarAdmin(ModelMap model,
            @RequestParam("idRescatado")int id) {
        
        Administrativo admin = adminServ.obtenerAdministrativo(id);
        model.addAttribute("usuario", admin);
        return new ModelAndView("editar-usuario");
    }

    @RequestMapping(value = "/EditarAdministrativo", method = RequestMethod.POST)
    public ModelAndView editarAdmin(
            @RequestParam("idUsuario")int id,
            @RequestParam("nombreUsuario") String nombreUsuario,
            @RequestParam("contraseña")String contrasena,
            @RequestParam("nombre") String nombre,
            @RequestParam("area") String area,
            @RequestParam("experienciaPrevia") String experiencia) {
        
       Administrativo admin = new Administrativo(id, nombreUsuario, contrasena,nombre,area,experiencia);
      adminServ.actualizar(admin);
       return new ModelAndView("exito")
               .addObject("mensaje", "Usuario modificado correctamente");
             
    } 
}