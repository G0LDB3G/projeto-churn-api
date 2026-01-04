package com.hackathon.churninsight.api.domain.cliente;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(
        name = "clientes",
        uniqueConstraints = @UniqueConstraint(columnNames = "customer_id")
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private String customerID;

    private String gender;
    private Integer seniorCitizen;
    private String partner;
    private String dependents;
    private Integer tenure;
    private String phoneService;
    private String multipleLines;
    private String internetService;
    private String onlineSecurity;
    private String onlineBackup;
    private String deviceProtection;
    private String techSupport;
    private String streamingTV;
    private String streamingMovies;
    private String contract;
    private String paperlessBilling;
    private String paymentMethod;

    @Column(precision = 10, scale = 2)
    private BigDecimal monthlyCharges;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalCharges;

    public Cliente(ClienteRequestDTO clienteDTO) {
        this.customerID = clienteDTO.customerID();
        this.gender = clienteDTO.gender();
        this.seniorCitizen = clienteDTO.seniorCitizen();
        this.partner = clienteDTO.partner();
        this.dependents = clienteDTO.dependents();
        this.tenure = clienteDTO.tenure();
        this.phoneService = clienteDTO.phoneService();
        this.multipleLines = clienteDTO.multipleLines();
        this.internetService = clienteDTO.internetService();
        this.onlineSecurity = clienteDTO.onlineSecurity();
        this.onlineBackup = clienteDTO.onlineBackup();
        this.deviceProtection = clienteDTO.deviceProtection();
        this.techSupport = clienteDTO.techSupport();
        this.streamingTV = clienteDTO.streamingTV();
        this.streamingMovies = clienteDTO.streamingMovies();
        this.contract = clienteDTO.contract();
        this.paperlessBilling = clienteDTO.paperlessBilling();
        this.paymentMethod = clienteDTO.paymentMethod();
        this.monthlyCharges = clienteDTO.monthlyCharges();
        this.totalCharges = clienteDTO.totalCharges();
    }
}

