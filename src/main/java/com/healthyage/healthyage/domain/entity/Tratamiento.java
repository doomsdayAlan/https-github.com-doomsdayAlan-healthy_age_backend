package com.healthyage.healthyage.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tratamiento {
    @JsonProperty("id_tratamiento")
    @Schema(description = "Id del tratamiento", example = "K1r2bz38FEgRTudHUMHx")
    private String idTratamiento;

    @JsonProperty("nombre_tratamiento")
    @NotBlank(message = "El nombre del tratamiento es requerido")
    @Schema(description = "Nombre dado al tratamiento", example = "Hipertensión")
    private String nombreTratamiento;

    @JsonProperty("id_usuario")
    @NotBlank(message = "El id de usuario es requerido")
    @Schema(description = "Id del usuario al que se le asigna el tratamiento", example = "K1r2bz38FEgRTudHUMHx")
    private String idUsuario;
    
    @JsonProperty("id_medicamento")
    @NotBlank(message = "El id de medicamento es requerido")
    @Schema(description = "Id del medicamento del tratamiento", example = "K1r2bz38FEgRTudHUMHx")
    private String idMedicamento;

    @NotBlank(message = "El medico es requerido")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$", message = "El nombre del médico solo debe contener letras válidas")
    @Schema(description = "Nombre del médico que preescribe el tratamiento", example = "K1r2bz38FEgRTudHUMHx")
    private String medico;

    @JsonProperty("fecha_inicio")
    @NotBlank(message = "La fecha de inicio es requerida")
    @Pattern(regexp = "^(0[1-9]|[12][\\d]|3[01])[\\/\\-](0[1-9]|1[0-2])[\\/\\-](19|20)\\d\\d$", message = "El formato de fecha es incorrecto (DD/MM/YYYY o DD-MM-YYYY)")
    @Schema(description = "Fecha en la que inicia el tratamiento", example = "03-11-2024")
    private String fechaInicio;

    @JsonProperty("fecha_fin")
    @NotBlank(message = "La fecha de fin es requerida")
    @Pattern(regexp = "^(0[1-9]|[12][\\d]|3[01])[\\/\\-](0[1-9]|1[0-2])[\\/\\-](19|20)\\d\\d$", message = "El formato de fecha es incorrecto (DD/MM/YYYY o DD-MM-YYYY)")
    @Schema(description = "Fecha en la que finaliza el tratamiento", example = "03-11-2024")
    private String fechaFin;

    @JsonProperty("hora_inicio")
    @NotBlank(message = "La hora de inicio del tratamiento es requerida")
    @Pattern(regexp = "^([01][\\d]|2[0-3]):[0-5][\\d]$", message = "El formato de hora es incorrecto (HH:mm) (24 horas)")
    @Schema(description = "Hora en la que inicia el tratamiento", example = "09:25")
    private String horaInicio;

    @Min(1)
    @Pattern(regexp = "^(?:[1-9]|1[\\d]|2[0-4])$", message = "La hora debe estar entre 1 y 24")
    @Schema(description = "Intervalo de tiempo entre tomas", example = "8")
    private int intervalo;

    @JsonProperty("tipo_intervalo")
    @NotBlank(message = "El tipo de intervalo es requerido")
    @Schema(description = "Intervalo de tiempo entre tomas", example = "HORAS")
    private String tipoIntervalo;

    @NotBlank(message = "La dosis es requerida")
    @Schema(description = "Dosis del medicamento del tratamiento", example = "2 unidades")
    private int dosis;
}
