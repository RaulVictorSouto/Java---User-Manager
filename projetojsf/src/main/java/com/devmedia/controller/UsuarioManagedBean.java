package com.devmedia.controller;

import com.devmedia.model.entity.Usuario;
import com.devmedia.model.dao.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "UsuarioMB")
@RequestScoped
public class UsuarioManagedBean {

    private Usuario usuario = new Usuario();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public List<Usuario> getUsuarios() {
        return usuarioDAO.getUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String cadastraUsuario() {
        try {
            usuario.setDataCadastro(new java.util.Date());
            usuarioDAO.saveUsuario(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", null));
            usuario = new Usuario();
            System.out.println("Usuário cadastrado com sucesso, redirecionando para listagem...");
            return "listagem?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar usuário: " + e.getMessage(), null));
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            
            return null; 
        }
    }

}
