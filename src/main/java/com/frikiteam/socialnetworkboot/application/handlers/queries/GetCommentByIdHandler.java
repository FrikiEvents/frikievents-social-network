package com.frikiteam.socialnetworkboot.application.handlers.queries;

import com.frikiteam.socialnetworkboot.application.dtos.CommentView;
import com.frikiteam.socialnetworkboot.application.queries.GetCommentByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class GetCommentByIdHandler {
  @PersistenceContext
  private EntityManager entityManager;

  @QueryHandler
  public CommentView handle(GetCommentByIdQuery query) {
    String sql = String.join(
        " ",
        "SELECT",
        "BIN_TO_UUID(id) AS id,",
        "content AS content ",
        "FROM comments",
        "WHERE id = UUID_TO_BIN(:id)"
    );

    return (CommentView) this.entityManager.createNativeQuery(sql)
        .setParameter("id", query.getId())
        .unwrap(org.hibernate.query.NativeQuery.class)
        .setResultTransformer(Transformers.aliasToBean(CommentView.class))
        .getSingleResult();
  }
}
