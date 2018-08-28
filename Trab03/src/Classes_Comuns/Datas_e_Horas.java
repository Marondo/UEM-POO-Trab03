/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Comuns;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Marondo
 */
public class Datas_e_Horas   implements Serializable{

    Calendar c;
    String data, horas;

    public Datas_e_Horas() {
        c = Calendar.getInstance();
        data =""+( c.get(Calendar.DAY_OF_MONTH)+"/"+ (c.get(Calendar.MONTH)+1)+"/"+ c.get(Calendar.YEAR));
        horas =""+ (c.get(Calendar.HOUR_OF_DAY)+":"+ c.get(Calendar.MINUTE)+":"+ c.get(Calendar.SECOND));
    }

    public String getData() {
        return data;
    }

    public String getHoras() {
        return horas;
    }

    @Override
    public String toString() {
        return ";" + this.data + ";" + this.horas;
    }

}
