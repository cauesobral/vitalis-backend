package com.cauesobral.vitalis.model;

import jakarta.persistence.*;
import java.util.Objects;

// Etapa de consulta: diagnóstico e prescrição feitos pelo médico
@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private String diagnosis;     // Diagnóstico do médico
    private String prescription;  // Prescrição / receita
    private String examRequests;  // Exames solicitados
    private String notes;         // Observações finais

    // @NoArgsConstructor — exigido pelo JPA
    public Consultation() {}

    // @Data → getters
    public Long getId() { return id; }
    public Appointment getAppointment() { return appointment; }
    public String getDiagnosis() { return diagnosis; }
    public String getPrescription() { return prescription; }
    public String getExamRequests() { return examRequests; }
    public String getNotes() { return notes; }

    // @Data → setters
    public void setId(Long id) { this.id = id; }
    public void setAppointment(Appointment appointment) { this.appointment = appointment; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setPrescription(String prescription) { this.prescription = prescription; }
    public void setExamRequests(String examRequests) { this.examRequests = examRequests; }
    public void setNotes(String notes) { this.notes = notes; }

    // @Data → equals e hashCode (baseado no id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consultation)) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // @Data → toString
    @Override
    public String toString() {
        return "Consultation{id=" + id + ", diagnosis='" + diagnosis
                + "', prescription='" + prescription + "', examRequests='" + examRequests
                + "', notes='" + notes + "'}";
    }
}
