using System.Collections.Generic;
using System.Linq;
using JetBrains.Application.Settings;
using JetBrains.ProjectModel;
using JetBrains.RdBackend.Common.Features;
using JetBrains.ReSharper.Feature.Services.Daemon;
using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.CSharp;
using JetBrains.ReSharper.Psi.CSharp.Tree;
using JetBrains.ReSharper.Psi.Files;
using JetBrains.ReSharper.Psi.Tree;
using JetBrains.Rider.Model;
using JetBrains.Util;

namespace ReSharperPlugin.StructureGlance.Daemon
{
    [DaemonStage]
    public class GlanceDaemon : IDaemonStage
    {
        private readonly ISolution _solution;
        private readonly StructureGlanceModel _glance;

        public GlanceDaemon(ISolution solution)
        {
            _solution = solution;
            _glance = solution.GetProtocolSolution().GetStructureGlanceModel();
        }

        public IEnumerable<IDaemonStageProcess> CreateProcess(
            IDaemonProcess process,
            IContextBoundSettingsStore settings,
            DaemonProcessKind processKind
        )
        {
            if (!IsCsharpFile(process.SourceFile)) return Enumerable.Empty<IDaemonStageProcess>();

            IEnumerable<IFile> files = process.SourceFile.GetPsiFiles<CSharpLanguage>();
            return files.SelectNotNull(x => new GlanceDaemonProcess((ICSharpFile) x, process, _glance));
        }

        private bool IsCsharpFile(IPsiSourceFile file)
        {
            if (file == null || !file.IsValid()) return false;

            return file.GetLanguages().Any(x => x.Is<CSharpLanguage>());
        }
    }
}