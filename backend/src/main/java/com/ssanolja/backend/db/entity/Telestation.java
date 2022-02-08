package com.ssanolja.backend.db.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "telestations")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Telestation {

    @Id
    @Column(name = "telestations_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer telestationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "games_id")
    private Game game;

//    // self join (둘 중 하나가 before_pk 같음)
//    // 부모 정의
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "before_pk")
//    private Telestation parent;
//
//    // 자식 정의
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
//    private List<Telestation> children;
//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "data_index")
    private String dataIndex;

    @Column(name = "text_data")
    private String textData;

    @Column(name = "drawing_data")
    private String drawingData;

    @Column(name = "drawing_order")
    private Integer drawingOrder;

    @Column(name = "bestvote")
    private String bestvote;

    @Column(name = "worstvote")
    private String worstvote;

    @Column(name = "user_order")
    private Integer userOrder;

}
