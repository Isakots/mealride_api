package hu.student.projlab.mealride_api.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.student.projlab.mealride_api.domain.converter.LocalDateAttributeConverter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name="CARD")
public class CreditCard extends AbstractEntity{

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @Pattern(regexp="[0-9]{16}", message="Car number format is not correct!")
    @Column(name="CARD_NUMBER")
    private String number;

    @Column(name="OWNER_NAME")
    private String ownername;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name="EXPIRATION_DATE")
    private LocalDate expriationdate;

    @JsonIgnore
    @Column(name="CVC")
    private String cvc; // hashed

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    public CreditCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public LocalDate getExpriationdate() {
        return expriationdate;
    }

    public void setExpriationdate(LocalDate expriationdate) {
        this.expriationdate = expriationdate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}