using System;
using System.Linq;
using JetBrains.Annotations;
using JetBrains.ReSharper.Daemon.CSharp.CodeFoldings;
using JetBrains.ReSharper.Feature.Services.Daemon;
using JetBrains.ReSharper.Psi.CSharp.Tree;
using JetBrains.ReSharper.Psi.Tree;
using JetBrains.Rider.Model;

namespace ReSharperPlugin.StructureGlance.Daemon
{
    public class GlanceDaemonProcess : CSharpCodeFoldingProcessor, IDaemonStageProcessWithPsiFile
    {
        private readonly ICSharpFile _file;
        private readonly IDaemonProcess _process;
        private readonly StructureGlanceModel _glance;

        public IDaemonProcess DaemonProcess => _process;
        public IFile File => _file;

        public GlanceDaemonProcess(ICSharpFile file, [NotNull] IDaemonProcess process, StructureGlanceModel glance)
        {
            _file = file;
            _process = process;
            _glance = glance;
        }

        public void Execute(Action<DaemonStageResult> committer)
        {
            var visitor = new GlanceVisitor();
            _file.Accept(visitor);

            _glance.OpenedFile.Fire(visitor.Declarations.ToArray());
        }
    }
}