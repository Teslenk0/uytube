/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DataTypes.DtCanal;
import DataTypes.DtVideo;
import clases.Canal;
import clases.Video;
import excepciones.VideoRepetidoException;
import interfaces.IControladorCanal;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tecnologo
 */
public class ControladorCanal implements IControladorCanal{
    
    @Override
    public void registrarVideo(DtVideo v) throws VideoRepetidoException{
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(v.getCanal().getNombre_canal(),v.getCanal().getDescripcion(),v.getCanal().getPrivado());
        Video video = new Video(v.getNombre(),canal,v.getFechaPublicacion(),v.getUrl(),v.getDescripcion(),v.getCategoria(),v.getDuracion(),v.isPrivado());
        try{
            mu.altaVideo(video);
        }catch(Exception c){
            throw new VideoRepetidoException("El video ya existe");
        }
    }
    
    @Override
    public List listaVideos(DtCanal c){
        ManejadorInformacion mu = ManejadorInformacion.getInstance();
        Canal canal = new Canal(c.getNombre_canal(),c.getDescripcion(),c.getPrivado());
        List lista = mu.listaVid(canal);
        return lista;
    }
}