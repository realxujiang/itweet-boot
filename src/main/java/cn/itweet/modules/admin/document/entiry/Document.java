package cn.itweet.modules.admin.document.entiry;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by whoami on 22/04/2017.
 */
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String filename;

    @Column(name = "rule_filename")
    private String ruleFilename;

    private String type;

    private Date date;
}
