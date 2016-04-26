function toggleSearchBlock() {
	var searchblock = document.getElementById('searchblock')
	searchblock.classList.toggle('hidden');
	document.getElementById('searchicon').classList.toggle('hidden');
	if (!searchblock.classList.contains('hidden')) {
		document.getElementById('searchtext').focus();
	}
}

function enableSearch() {
	document.getElementById('searchbutton').classList.remove('disabled');
}

function search() {
	var searchtext = document.getElementById('searchtext').value;
	document.getElementById('searchtext').value = "";
	window.location = "https://cse.google.com/cse/publicurl?cx=007461859296615640740:ghqya6epxmk&q="
			+ searchtext;
	toggleSearchBlock();
	return false;
}
