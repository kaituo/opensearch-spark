/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.sql.ast.expression;

import com.google.common.collect.ImmutableList;
import org.opensearch.sql.ast.AbstractNodeVisitor;

import java.util.Collections;
import java.util.List;
public class Field extends UnresolvedExpression {
  private final UnresolvedExpression field;
  private final List<Argument> fieldArgs;

  /** Constructor of Field. */
  public Field(UnresolvedExpression field) {
    this(field, Collections.emptyList());
  }

  /** Constructor of Field. */
  public Field(UnresolvedExpression field, List<Argument> fieldArgs) {
    this.field = field;
    this.fieldArgs = fieldArgs;
  }

  public UnresolvedExpression getField() {
    return field;
  }

  public List<Argument> getFieldArgs() {
    return fieldArgs;
  }

  public boolean hasArgument() {
    return !fieldArgs.isEmpty();
  }

  @Override
  public List<UnresolvedExpression> getChild() {
    return ImmutableList.of(this.field);
  }

  @Override
  public <R, C> R accept(AbstractNodeVisitor<R, C> nodeVisitor, C context) {
    return nodeVisitor.visitField(this, context);
  }
}
