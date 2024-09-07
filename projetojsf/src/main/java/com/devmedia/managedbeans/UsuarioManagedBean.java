package com.devmedia.managedbeans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.devmedia.model.Connect;
import com.devmedia.model.Usuario;

@ManagedBean(name = "UsuarioMB")
@RequestScoped
public class UsuarioManagedBean {

    private Usuario usuario = new Usuario();

    // Getter e Setter para 'usuario'
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para cadastrar usuário
    public String cadastraUsuario() {
        Connect con = null;
        try {
            con = new Connect();
            boolean sucesso = con.insertUsuario(usuario);
            if (sucesso) {
                FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Sucesso!", "Usuário cadastrado com sucesso!")
                );
                // Retorna a string de navegação para 'listagem.xhtml' com redirecionamento
                return "listagem?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro!", "Erro no cadastro de usuário!")
                );
                // Permanece na mesma página
                return null;
            }
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro!", "Erro ao conectar com o banco de dados: " + e.getMessage())
            );
            return null;
        } finally {
            if (con != null) {
                try {
                    con.closeConnection();
                } catch (SQLException e) {
                    FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro!", "Erro ao fechar a conexão: " + e.getMessage())
                    );
                }
            }
        }
    }

    // Método para listar usuários
    public List<Usuario> getUsuarios() {
        Connect con = null;
        try {
            con = new Connect();
            List<Usuario> listaUsuarios = con.listUsuarios();
            return listaUsuarios;
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro!", "Erro ao conectar com o banco de dados: " + e.getMessage())
            );
            return null;
        } finally {
            if (con != null) {
                try {
                    con.closeConnection();
                } catch (SQLException e) {
                    FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro!", "Erro ao fechar a conexão: " + e.getMessage())
                    );
                }
            }
        }
    }
}
