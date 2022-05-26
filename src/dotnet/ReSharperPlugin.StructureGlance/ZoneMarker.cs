using JetBrains.Application.BuildScript.Application.Zones;

namespace ReSharperPlugin.StructureGlance
{
    [ZoneMarker]
    public class ZoneMarker : IRequire<IStructureGlanceZone>
    {
    }
}