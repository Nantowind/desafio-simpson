package com.leafnoise.desafiosimpson.controller;

import com.leafnoise.desafiosimpson.entitys.Homero;
import com.leafnoise.desafiosimpson.entitys.PatoBalancin;
import com.leafnoise.desafiosimpson.entitys.PlantaNuclear;
import com.leafnoise.desafiosimpson.entitys.SrBurns;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.leafnoise.desafiosimpson.services.PlantaNuclearServices.calcularResultados;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @PostMapping("/enviar-donas")
    public String processDonasForm(
            @RequestParam("donas-cantidad-homero") int donasCantidadHomero,
            @RequestParam("donas-eduardo") int donasEduardo,
            @RequestParam("donas-robadas") int donasRobadas,
            Model model) {

        try {
            Map<String, Object> resultados = calcularResultados(donasCantidadHomero, donasEduardo, donasRobadas);
            fillModel(model, (Homero) resultados.get("homero"), (PatoBalancin) resultados.get("patoBalancin"),
                    (SrBurns) resultados.get("srBurns"), (PlantaNuclear) resultados.get("plantaNuclear"));
            // Renderizar la vista de resultado
            return "resultado";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }


    }

    private void fillModel(Model model, Homero homero, PatoBalancin patoBalancin, SrBurns srBurns, PlantaNuclear plantaNuclear) {
        boolean homeroDistraido = homero.isDistraido();
        boolean homeroLoco = homero.isLoco();
        boolean patoDistraido = patoBalancin.isDistraido();
        boolean patoLoco = patoBalancin.isLoco();
        boolean srBurnsBancaRota = srBurns.isBancaRota();
        boolean plantaEnPeligro = plantaNuclear.isEstaEnPeligro();
        int uranio = plantaNuclear.getCantidadUranio();

        model.addAttribute("homeroDistraido", homeroDistraido);
        model.addAttribute("homeroLoco", homeroLoco);
        model.addAttribute("patoDistraido", patoDistraido);
        model.addAttribute("patoLoco", patoLoco);
        model.addAttribute("srBurnsBancaRota", srBurnsBancaRota);
        model.addAttribute("algunaCondicionCumplida", homeroDistraido || homeroLoco || patoDistraido || patoLoco || srBurnsBancaRota || plantaEnPeligro);
        model.addAttribute("plantaEnPeligro", plantaEnPeligro);
        model.addAttribute("uranio", uranio);
    }




}
