package com.hackathon.churninsight.api.domain.cliente;

import com.hackathon.churninsight.api.domain.cliente.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * Entidade Cliente
 * Representa o cliente persistido no banco de dados.
 *
 * Essa entidade guarda os dados originais do cliente
 * e pode ser reutilizada futuramente para análises,
 * relatórios e histórico de previsões.
 */
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

    /**
     * ID original do cliente (ex: dataset da IBM)
     * Deve ser único.
     */
    @Column(name = "customer_id", nullable = false)
    private String customerID;

    private String gender;

    /**
     * Indica se o cliente é idoso (0 ou 1)
     */
    private Integer seniorCitizen;

    private String partner;
    private String dependents;

    /**
     * Tempo de permanência do cliente (em meses)
     */
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

    /**
     * Tipo de contrato (Month-to-month, One year, Two year)
     */
    private String contract;

    private String paperlessBilling;
    private String paymentMethod;

    /**
     * Valor cobrado mensalmente
     */
    private BigDecimal monthlyCharges;

    /**
     * Valor total gasto pelo cliente
     */
    private BigDecimal totalCharges;


    public Cliente(ClienteRequestDTO dto) {
        this.customerID = dto.customerID();
        this.gender = dto.gender();
        this.seniorCitizen = dto.seniorCitizen();
        this.partner = dto.partner();
        this.dependents = dto.dependents();
        this.tenure = dto.tenure();
        this.phoneService = dto.phoneService();
        this.multipleLines = dto.multipleLines();
        this.internetService = dto.internetService();
        this.onlineSecurity = dto.onlineSecurity();
        this.onlineBackup = dto.onlineBackup();
        this.deviceProtection = dto.deviceProtection();
        this.techSupport = dto.techSupport();
        this.streamingTV = dto.streamingTV();
        this.streamingMovies = dto.streamingMovies();
        this.contract = dto.contract();
        this.paperlessBilling = dto.paperlessBilling();
        this.paymentMethod = dto.paymentMethod();
        this.monthlyCharges = dto.monthlyCharges();
        this.totalCharges = dto.totalCharges();
    }

}
