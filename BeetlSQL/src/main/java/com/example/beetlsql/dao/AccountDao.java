package com.example.beetlsql.dao;

import com.example.beetlsql.pojo.Account;
import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;

public interface AccountDao extends BaseMapper<Account> {

    @SqlStatement(params = "name")
    Account queryAccountByName(String name);
}
