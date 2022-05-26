using JetBrains.Application.BuildScript.Application.Zones;
using JetBrains.ProjectModel;
using JetBrains.ReSharper.Feature.Services.Daemon;
using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.CSharp;
using JetBrains.ReSharper.Resources.Shell;
using JetBrains.Rider.Backend.Env;
using JetBrains.Rider.Backend.Product;

namespace ReSharperPlugin.StructureGlance
{
    [ZoneDefinition(ZoneFlags.AutoEnable)]
    public interface IStructureGlanceZone : IZone,
        IRequire<IPsiLanguageZone>,
        IRequire<ILanguageCSharpZone>,
        IRequire<DaemonZone>,
        IRequire<IRiderFeatureZone>,
        IRequire<IRiderProductEnvironmentZone>,
        IRequire<IProjectModelZone>
    {
    }
}