using System.Collections.Generic;
using JetBrains.ReSharper.Psi.CSharp.Tree;
using JetBrains.ReSharper.Psi.Tree;
using JetBrains.Rider.Model;

namespace ReSharperPlugin.StructureGlance.Daemon
{
    public class GlanceVisitor : TreeNodeVisitor
    {
        private List<MemberSignature> _declarations;

        public IReadOnlyCollection<MemberSignature> Declarations => _declarations;

        public GlanceVisitor()
        {
            _declarations = new List<MemberSignature>();
        }

        public override void VisitNode(ITreeNode node)
        {
            if (node is ICSharpFile file)
            {
                VisitCSharpFile(file);
            }
            else if (node is IClassDeclaration classDeclaration)
            {
                VisitClassDeclaration(classDeclaration);
            }
            else if (node is IMethodDeclaration methodDeclaration)
            {
                VisitMethodDeclaration(methodDeclaration);
            }
        }

        public override void VisitCSharpFile(ICSharpFile cSharpFileParam)
        {
            var namespaces = cSharpFileParam.NamespaceDeclarationNodes;
            foreach (var @namespace in namespaces)
            {
                foreach (var type in @namespace.TypeDeclarations)
                {
                    if (type is IClassDeclaration classDeclaration)
                        VisitNode(classDeclaration);
                }
            }
        }

        public override void VisitClassDeclaration(IClassDeclaration classDeclarationParam)
        {
            foreach (var methodDeclaration in classDeclarationParam.MethodDeclarations)
            {
                VisitNode(methodDeclaration);
            }
        }

        public override void VisitMethodDeclaration(IMethodDeclaration methodDeclarationParam)
        {
            _declarations.Add(
                new MemberSignature(methodDeclarationParam.DeclaredName, SignatureType.Class)
            );
        }
    }
}