package util;

public class PageSRC{
    private final static HashMap<String, String> pageSRC = new HashMap<String, String>();
    
    static{
        pageSRC.put(HomePageSelector.ADD_ITEM, "/pages/adicionarItem.html");
        pageSRC.put(HomePageSelector.VIEW_ITENS, "/pages/visualizarItem.html");
        pageSRC.put(HomePageSelector.ADD_GROUP, "/pages/adicionarGrupo.html");
        pageSRC.put(HomePageSelector.VIEW_GROUPS, "/pages/visualizarGrupos.html");
        pageSRC.put(HomePageSelector.EDIT_GROUP, "/pages/editarGrupo.html");
        pageSRC.put(HomePageSelector.VIEW_GROUP_MEMBERS, "/pages/usuariosGrupo.html");
        pageSRC.put(HomePageSelector.VALIDATE_USER, "/pages/validarUsuario.html");
        pageSRC.put(HomePageSelector.VIEW_USERS, "/pages/visualizarUsuarios.html");
        pageSRC.put(HomePageSelector.EDIT_USER, "/pages/editarUsuario.html");
    }
}