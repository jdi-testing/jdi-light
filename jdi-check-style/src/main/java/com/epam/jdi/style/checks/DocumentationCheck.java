package com.epam.jdi.style.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.checks.naming.AccessModifierOption;
import com.puppycrawl.tools.checkstyle.utils.CheckUtil;

public class DocumentationCheck extends AbstractCheck {
    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.METHOD_DEF};
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return getDefaultTokens();
    }

    @Override
    public void visitToken(DetailAST ast) {
        final AccessModifierOption accessModifier = CheckUtil.getAccessModifierFromModifiersToken(ast);
        if (AccessModifierOption.PUBLIC.equals(accessModifier)) {
            final DetailAST modifiers = ast.findFirstToken(TokenTypes.MODIFIERS);
            if (modifiers != null) {
                DetailAST annotation = modifiers.findFirstToken(TokenTypes.ANNOTATION);
                while (annotation != null) {
                    String annotationName = CheckUtil.extractQualifiedName(annotation);
                    if (annotationName.contains("JDIAction")) {
                        return;
                    }
                    annotation = annotation.getNextSibling();
                }
            }
            // report the error
            log(ast, "Public methods requires JDIAction annotation");
        }
    }
}
