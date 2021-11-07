package com.francescxavier.videotogethercliente.utils;

import com.francescxavier.videotogethercliente.Sala;
import com.francescxavier.videotogethercliente.User;
import com.francescxavier.videotogethercliente.enums.PetitionType;
import com.francescxavier.videotogethercliente.enums.ResponseType;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;

public class NetUtils {
    public static String Separator = "_";

    public static String IpServidor = "localhost";

    public static ResponseType login(String user, String password){

        User usuario = null;

        Petition peticion = new Petition(PetitionType.LOGIN,user+NetUtils.Separator+password);
        Response response = sendMessageWithResponse(peticion);

        switch (response.getResponseType()){

            case OK:
                System.out.println("Inicio de sesión exitoso.");

                usuario = new User(user,response.getContenido());
                User.setUsuario(usuario);
                System.out.println(usuario.getId());
                break;

            case NO:
                System.out.println("Usuario o contraseña incorrecto.");
                break;

            case ALREADYLOGED:
                System.out.println("El usuario ya ha iniciado sesión anteriormente.");
                break;

            case FAIL: case UNKNOWN:
                System.out.println("Ha ocurrido un error desconocido.");
                break;
        }


        return response.getResponseType();
    }


    public static Sala joinSala(String idSala){
        Sala sala = null;

        Petition petition = new Petition(PetitionType.JOINSALA,idSala);
        Response response = sendMessageWithResponse(petition);

        System.out.println(petition);

        switch (response.getResponseType()){
            case OK:
                String[] tmpListaUsuarios = response.getContenido().split(NetUtils.Separator);
                HashSet<String> listaUsuarios = new HashSet<>();

                for (String usuario : tmpListaUsuarios){
                    listaUsuarios.add(usuario);
                }

                sala = new Sala(idSala, listaUsuarios);
            break;

            case NO:
                System.out.println("No se ha podido entrar en la sala.");
                break;
            default:
                System.out.println("Ha ocurrido un error: "+response.getResponseType()+", "+response.getContenido());
        }

        return sala;

    }

    public static Sala createSala(){
        Sala sala = null;

        Petition petition = new Petition(PetitionType.CREATESALA,"");
        Response response = sendMessageWithResponse(petition);

        switch (response.getResponseType()){
            case OK:
                String[] tmpListaUsuarios = response.getContenido().split(NetUtils.Separator);
                HashSet<String> listaUsuarios = new HashSet<>();

                for (String usuario : tmpListaUsuarios){
                    listaUsuarios.add(usuario);
                }

                sala = new Sala(response.getContenido(),new HashSet());
                break;

            case NO:
                System.out.println("No se ha podido entrar en la sala.");
                break;
            default:
                System.out.println("Ha ocurrido un error: "+response.getResponseType()+", "+response.getContenido());
        }

        return sala;
    }



    public static Response sendMessageWithResponse(Petition petition){

        Response response = null;

        try {
            Socket socket = new Socket(IpServidor, 4444);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            ResponseType responseType;

            output.println(petition);
            output.flush();

            String respuesta = input.readLine();

            if (respuesta != null){
                String[] resultado = respuesta.split(NetUtils.Separator,2);
                System.out.println(resultado[0]);
                switch (resultado[0]){
                    case "ok":
                        responseType = ResponseType.OK;
                        break;

                    case "no":
                        responseType = ResponseType.NO;
                        break;

                    case "fail":
                        responseType = ResponseType.FAIL;
                        break;

                    case "alreadyLoged":
                        responseType = ResponseType.ALREADYLOGED;
                        break;

                    default:
                        responseType = ResponseType.UNKNOWN;
                        break;
                }

                String contenido = "";

                if (resultado.length > 1){
                    contenido = resultado[1];
                }

                response = new Response(responseType,contenido);
            }


            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}


