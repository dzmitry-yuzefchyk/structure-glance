using System.Threading;
using JetBrains.Application.BuildScript.Application.Zones;
using JetBrains.ReSharper.Feature.Services;
using JetBrains.ReSharper.Feature.Services.Daemon;
using JetBrains.ReSharper.Feature.Services.ExternalSources;
using JetBrains.ReSharper.Feature.Services.Navigation;
using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.CSharp;
using JetBrains.ReSharper.Resources.Shell;
using JetBrains.ReSharper.TestFramework;
using JetBrains.Rider.Backend.Env;
using JetBrains.Rider.Backend.Product;
using JetBrains.TestFramework;
using JetBrains.TestFramework.Application.Zones;
using NUnit.Framework;

[assembly: Apartment(ApartmentState.STA)]

namespace ReSharperPlugin.StructureGlance.Tests
{
    [ZoneDefinition]
    public class StructureGlanceTestEnvironmentZone : ITestsEnvZone, IRequire<PsiFeatureTestZone>,
        IRequire<IStructureGlanceZone>
    {
    }

    [ZoneMarker]
    public class ZoneMarker : IRequire<StructureGlanceTestEnvironmentZone>, IRequire<IStructureGlanceZone>,
        IRequire<IRiderFeatureZone>,
        IRequire<IRiderProductEnvironmentZone>,
        IRequire<ILanguageCSharpZone>,
        IRequire<DaemonZone>,
        IRequire<NavigationZone>,
        IRequire<ICodeEditingZone>,
        IRequire<ExternalSourcesZone>,
        IRequire<PsiFeaturesImplZone>,
        IRequire<ILanguageCppZone>
    {
    }

    [SetUpFixture]
    public class StructureGlanceTestsAssembly : ExtensionTestEnvironmentAssembly<StructureGlanceTestEnvironmentZone>
    {
    }
}