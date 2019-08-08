from .observer import MultiplexingObserver, LoggingObserver, JSObserver

customwebassets="/home/clayn/assets"

def townFilter(poi):
    if poi['id'] == 'Town':
        return poi['name']

def playerIcons(poi):
    if poi['EntityId'] == 'Solfan':
        poi['icon'] = "solf.png"
        return "Last known location for Solfan"
    if poi['id'] == 'Player':
        poi['icon']="solf.png"
        return "Last known location for %s" % poi['EntityId']

def poiFilter(poi):
    if poi['id'] == 'POI':
        return poi['name']


def towerFilter(poi):
    if poi['id'] == 'Tower':
        return poi['name']


worlds["Hidden Leaf"] = "/home/clayn/minecraft/world"

renders["day"] = {
    "world": "Hidden Leaf",
    "title": "Hidden Leaf Minecraft NW",
    "dimension": "overworld",
    "northdirection":"upper-left",
    "rendermode": "smooth_lighting",
    'manualpois': [
        {'id': 'Town',
             'x': 280,
             'y': 64,
             'z': -63,
             'name': 'Konohagakure',
             'description': 'Best place to eat hamburgers'},
        {'id': 'Tower',
         'x': 1480,
         'y': 64,
         'z': 607,
         'name': 'Der grosse Leuchtturm'},
        {'id': 'POI',
         'x': 371,
         'y': 64,
         'z': -1211,
         'name': 'Das Tal des Endes'},
	{'id': 'Tower',
	 'x':13033,
	 'y': 82,
	 'z':2135,
	 'name':'Turm der Ungerechtigkeit'}],
    'markers': [dict(name='Spieler', checked=True, filterFunction=playerIcons, createInfoWindow=True),dict(name='Towers', checked=True, filterFunction=towerFilter, createInfoWindow=True, icon="icons/marker_tower.png"),
                dict(name='Sehenswuerdigkeiten', checked=True, filterFunction=poiFilter, createInfoWindow=True, icon="icons/marker_base_plain.svg"), dict(name='Towns', filterFunction=townFilter, checked=True, createInfoWindow=True, icon="icons/marker_town.png")]
,}

renders["night"] = {
    "world": "Hidden Leaf",
    "title": "Hidden Leaf Minecraft Night NW",
    "northdirection":"upper-left",
    "dimension": "overworld",
    "rendermode": "smooth_night",
    'manualpois': [
                   {'id': 'Town',
                    'x': 280,
                    'y': 64,
                    'z': -63,
                    'name': 'Konohagakure',
                    'description': 'Best place to eat hamburgers'},
        {'id': 'Tower',
                       'x': 1480,
                       'y': 64,
                       'z': 607,
                       'name': 'Der grosse Leuchtturm'},
        {'id': 'POI',
                       'x': 371,
                       'y': 64,
                       'z': -1211,
                       'name': 'Das Tal des Endes'}],
    'markers': [dict(name='Spieler', checked=True, filterFunction=playerIcons, createInfoWindow=True, icon="icons/marker_base_plain.svg"),dict(name='Towers', filterFunction=towerFilter, checked=True, createInfoWindow=True, icon="icons/marker_tower.png"),
                dict(name='Sehenswuerdigkeiten', filterFunction=poiFilter, checked=True, createInfoWindow=True, icon="icons/marker_base_plain.svg"), dict(name='Towns', filterFunction=townFilter, checked=True, createInfoWindow=True, icon="icons/marker_town.png")],
}

renders["nether"] = {
    "world": "Hidden Leaf",
    "title": "Hidden Leaf Minecraft Nethera",
    "rendermode": nether_lighting,
    "dimension": "nether",
}

outputdir = "/var/www/html/minecraft"


#jsObserver = JSObserver(outputdir, 10)
logging = LoggingObserver()
observer = MultiplexingObserver(logging)
