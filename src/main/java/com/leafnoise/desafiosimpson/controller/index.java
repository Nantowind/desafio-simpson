package com.leafnoise.desafiosimpson.controller;

import com.leafnoise.desafiosimpson.entitys.Homero;
import com.leafnoise.desafiosimpson.entitys.PatoBalancin;
import com.leafnoise.desafiosimpson.entitys.PlantaNuclear;
import com.leafnoise.desafiosimpson.entitys.SrBurns;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class index {

    @GetMapping("/index")
    public String inicio() {
        return "index";
    }

    @PostMapping("/enviar-donas")
    public String procesarFormulario(
            @RequestParam("donas-cantidad-homero") int donasCantidadHomero,
            @RequestParam("donas-eduardo") int donasEduardo,
            @RequestParam("donas-robadas") int donasRobadas,
            Model model) {

        if (donasCantidadHomero - donasRobadas < 0) {
            model.addAttribute("error", "Las donas robadas son más de las que Homero tiene");
            return "index";
        }

        donasCantidadHomero = donasCantidadHomero - donasRobadas;
        Homero homero = new Homero(donasCantidadHomero);
        PatoBalancin patoBalancin = new PatoBalancin(donasEduardo, donasRobadas);

        SrBurns srBurns = new SrBurns(donasCantidadHomero + donasEduardo);

        PlantaNuclear plantaNuclear = new PlantaNuclear(homero.getEnergia(),
                patoBalancin.getEnergia());


        boolean homeroDistraido = homero.isDistraido();
        boolean homeroLoco = homero.isLoco();
        boolean patoDistraido = patoBalancin.isDistraido();
        boolean patoLoco = patoBalancin.isLoco();
        boolean srBurnsBancaRota = srBurns.isBancaRota();
        boolean plantaNuclearPeligro = plantaNuclear.isEstaEnPeligro();
        int uranio = plantaNuclear.getCantidadUranio();


        boolean algunaCondicionCumplida = homeroDistraido || homeroLoco || patoDistraido ||
                patoLoco || srBurnsBancaRota || plantaNuclearPeligro;

        model.addAttribute("homeroDistraido", homeroDistraido);
        model.addAttribute("homeroLoco", homeroLoco);
        model.addAttribute("patoDistraido", patoDistraido);
        model.addAttribute("patoLoco", patoLoco);
        model.addAttribute("srBurnsBancaRota", srBurnsBancaRota);
        model.addAttribute("algunaCondicionCumplida", algunaCondicionCumplida);
        model.addAttribute("peligro", plantaNuclearPeligro);
        model.addAttribute("uranio", uranio);

        return "resultado";
    }


}
