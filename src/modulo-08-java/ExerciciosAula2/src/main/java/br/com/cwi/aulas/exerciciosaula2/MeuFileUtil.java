/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aulas.exerciciosaula2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author alana.souza
 */
public class MeuFileUtil {

    public void mk(String arquivo) {
        try {
            if (arquivo.contains(".")) {
                final boolean a = new File(arquivo).createNewFile();
            } else {
                final boolean b = new File(arquivo).mkdir();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rm(String arquivo) {
        final File file = new File(arquivo);
        if (file.isFile()) {
            final boolean c = file.delete();
            System.out.println("Arquivo excluído com sucesso.");
        } else {
            System.out.println("Não é possível excluir pois a entrada é um diretório");
        }
    }

    public void ls(String arquivo) {
        final File file = new File(arquivo);
        if (file.isFile()) {
            final String path = new File(arquivo).getAbsolutePath();
        } else {
            final String[] list = new File(arquivo).list();
        }
    }
}
