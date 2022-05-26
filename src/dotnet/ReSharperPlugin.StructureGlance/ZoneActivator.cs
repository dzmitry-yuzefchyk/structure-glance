using JetBrains.Application.Environment;
using JetBrains.ProjectModel;
using JetBrains.ReSharper.Feature.Services.Daemon;
using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.CSharp;
using JetBrains.Rider.Backend.Env;
using JetBrains.Rider.Backend.Product;

namespace ReSharperPlugin.StructureGlance
{
    [ZoneActivator]
    public class ZoneActivator : IActivate<IPsiLanguageZone>,
        IActivate<IStructureGlanceZone>,
        IActivate<ILanguageCSharpZone>,
        IActivate<DaemonZone>,
        IActivate<IRiderFeatureZone>,
        IActivate<IRiderProductEnvironmentZone>,
        IActivate<IProjectModelZone>
    {
    }
}