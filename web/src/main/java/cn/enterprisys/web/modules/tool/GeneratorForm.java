package cn.enterprisys.web.modules.tool;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class GeneratorForm {

    private String codeType;
    private String packageName;
    private String moduleName;
    private String dbType;
    private String outputDir;
    private String baseMenuId;
    private String menuName;
    private String tableId;
    private String baseContext;
    private String context;
    private String author;
    private String ip;
    private String prot;
    private String database;
    private String username;
    private String password;
    private String tableNames;
    private String tablePrefixs;

}
