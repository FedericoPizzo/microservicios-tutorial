package com.moto.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;

@RestController
//Por donde ingreso a mi microservicio es la entrada a los servicios
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	private MotoService motoService;

	// obtengo todos los usuarios
	@GetMapping
	public ResponseEntity<List<Moto>> listarMotos() {
		List<Moto> motos = motoService.getAll();
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(motos);
	}

	// obtengo un solo usuario
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMotos(@PathVariable("id") int id) {
		Moto moto = motoService.getMotoById(id);
		if (moto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto);
	}

	// Guardo usuario
	@PostMapping
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
		Moto nuevoUsuario = motoService.save(moto);
		return ResponseEntity.ok(nuevoUsuario);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotosPorUsuario(@PathVariable("usuarioId") int id) {
		List<Moto> motos = motoService.byUsuarioId(id);
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(motos);
	}

}
